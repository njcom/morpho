# Complex Workflow: Kubernetes Operator Development

## Project Overview

project-goal:
  Develop a Kubernetes operator for managing database backups.

  scope:
    Custom resource definitions for backup schedules.
    Controller to reconcile desired state.
    Integration with cloud storage providers.

  out-of-scope:
    Database restore functionality (future phase).
    Multi-cluster coordination.

## Current Status

+ Project initialized #setup
+ CRD design completed #design
- Implement reconciliation loop #implementation, #core
  Currently working on this.
-!! Controller crashes on malformed CRD #bug, #critical
  Need to add validation webhook.

## Technical Architecture

```l
operator-components:
  Components that make up the backup operator.

  crd-definition:
    kind: DatabaseBackup
    api-version: backup.example.com/v1alpha1
    fields:
      schedule: cron-expression
      database-ref: reference-to-database-resource
      storage-provider: s3 | gcs | azure-blob
      retention-policy: duration

  controller-reconciler:
    Watches DatabaseBackup resources and ensures backup jobs created.

    reconciliation-logic:
      get-resource -> validate -> create-cronjob -> update-status

    error-handling:
      retry-on-failure: exponential-backoff
      max-retries: 5
      requeue-after: 30s

  backup-executor:
    Job that performs actual backup operation.

    execution-flow:
      connect-to-db -> dump-schema -> compress -> upload -> verify -> cleanup

    configuration:
      timeout: 3600s
      resource-limits:
        cpu: 500m
        memory: 1Gi
```

## Implementation Tasks

### Phase 1: Core Functionality

+ Define CRD schema #crd, #api
  schema-location: config/crd/bases/backup.example.com_databasebackups.yaml

  validation:
    schedule must be valid cron expression
    storage-provider must be one of allowed values
    retention-policy minimum 1 day

+ Create controller scaffold #controller, #setup
  Used kubebuilder to generate project structure.

  project-structure:
    api/v1alpha1/
      databasebackup_types.go
    controllers/
      databasebackup_controller.go
    config/
      crd/
      rbac/
      manager/

- Implement reconciliation loop #controller, #core
  Current focus of development.

  reconcile-function:
    Signature in Go:
    ```go
    func (r *DatabaseBackupReconciler) Reconcile(
      ctx context.Context,
      req ctrl.Request,
    ) (ctrl.Result, error)
    ```

  logic-steps:
    - Fetch DatabaseBackup resource
      Handle not-found case gracefully.

    - Validate resource spec
      Check all required fields present.
      Validate cron expression syntax.

    - Create or update CronJob
      cronjob-name: backup-{resource-name}
      schedule: from resource spec
      job-template: uses backup-executor image

    - Update resource status
      last-backup-time: timestamp
      next-backup-time: calculated from cron
      condition: ready | pending | error

  - Write reconciliation logic #implementation
  - Add error handling #implementation
  - Implement status updates #implementation
  - Add logging and metrics #observability

-!! Validation missing, controller crashes #bug, #critical
  When CRD has invalid cron expression, controller panics.

  root-cause:
    No validation webhook configured.
    Reconciler doesn't validate before using fields.

  fix-approach:
    - Add validation webhook #validation, #security
      Webhook validates CRD before admission.

      validation-rules:
        schedule: regex match cron pattern
        retention-policy: minimum 86400 (1 day in seconds)
        storage-provider: enum validation

    - Add defensive checks in reconciler #validation
      Even with webhook, reconciler should validate.

### Phase 2: Storage Integration

- Implement S3 storage backend #storage, #aws
  storage-interface:
    ```go
    type StorageBackend interface {
      Upload(ctx context.Context, data io.Reader, path string) error
      List(ctx context.Context, prefix string) ([]Object, error)
      Delete(ctx context.Context, path string) error
    }
    ```

  s3-implementation:
    Uses AWS SDK for Go v2.
    Supports custom endpoints for S3-compatible storage.

    configuration:
      region: from environment or resource annotation
      bucket: from DatabaseBackup spec
      credentials: from kubernetes secret

  - Create storage interface #design
  - Implement S3 backend #implementation
  - Add integration tests #testing
  - Handle credentials rotation #security

- Support GCS storage backend #storage, #gcp
-? Support Azure Blob storage #storage, #azure
  Undecided if needed for initial release.
  No current users on Azure platform.

### Phase 3: Advanced Features

- Implement retention policy enforcement #lifecycle
  retention-logic:
    List backups older than retention period.
    Delete expired backups from storage.
    Update metrics for storage usage.

  Run as separate controller watching BackupJob resources.

- Add backup verification #verification, #quality
  After upload, download sample and verify integrity.

  verification-steps:
    download-header -> validate-format -> checksum-match

- Support incremental backups #optimization
  Currently only full backups supported.
  Incremental would reduce storage costs.

  -? Research incremental backup strategies for different databases
    PostgreSQL: WAL archiving
    MySQL: binary log position
    MongoDB: oplog tailing

## Testing Strategy

```l
test-levels:
  Unit tests for individual components.
  Integration tests with fake Kubernetes API.
  E2E tests in real cluster.

unit-tests:
  coverage-target: 80%
  focus-areas:
    Validation logic
    Reconciliation state machine
    Storage backend implementations

  + Write tests for CRD validation #testing
  - Write tests for reconciler #testing
  - Write tests for storage backends #testing

integration-tests:
  Use envtest from controller-runtime.
  Spins up control plane components locally.

  test-scenarios:
    Create DatabaseBackup resource
    Verify CronJob created
    Update DatabaseBackup schedule
    Verify CronJob updated
    Delete DatabaseBackup
    Verify CronJob deleted

  - Setup envtest infrastructure #testing, #setup
  - Write integration test suite #testing

e2e-tests:
  Run in kind cluster with real database.

  test-flow:
    deploy-operator -> create-test-db -> create-backup-crd -> wait-for-backup -> verify-in-storage

  - Create E2E test framework #testing, #infrastructure
  - Write smoke tests #testing
  - Add to CI pipeline #ci
```

## Deployment

```l
deployment-strategy:
  Use Helm chart for operator deployment.

  chart-structure:
    templates/
      crd.yaml
      deployment.yaml
      service-account.yaml
      rbac.yaml
      webhook.yaml

  configuration-values:
    image:
      repository: example.com/backup-operator
      tag: v0.1.0
      pull-policy: IfNotPresent

    replicas: 2
    resources:
      limits:
        cpu: 200m
        memory: 256Mi
      requests:
        cpu: 100m
        memory: 128Mi

    webhook:
      enabled: true
      port: 9443
      certificate:
        generate: true

  + Create Helm chart structure #packaging
  - Add deployment templates #packaging
  - Configure RBAC permissions #security
  - Setup webhook certificates #security
  - Test installation in kind #testing
```

## Current Problems

```l
-!!! Controller panics on invalid input #bug, #critical, #blocker
  Blocks release to staging environment.

  symptoms:
    Operator pod crashes when DatabaseBackup has invalid cron.
    Pod enters CrashLoopBackoff.
    No backups can be scheduled.

  investigation:
    checked-logs: panic in reconciler
    reviewed-code: missing validation
    verified-crd: no validation rules in schema

  solution-in-progress:
    - Add admission webhook for validation #fix, #priority-1
      Prevents invalid resources from being created.

    - Add defensive validation in reconciler #fix, #priority-2
      Gracefully handle invalid state.

    - Add comprehensive unit tests #fix, #prevention
      Catch similar issues before production.

-!! Integration tests flaky in CI #testing, #ci
  Pass locally but fail ~30% of time in CI.

  possible-causes:
    Timing issues with controller startup.
    Resource constraints in CI environment.
    Race conditions in test setup.

  - Add retry logic to integration tests #fix
  - Increase timeouts for CI environment #fix
  - Investigate resource allocation #investigation

-! Documentation outdated #documentation
  README still references old API version.
  Installation guide missing webhook setup.

  + Update README with current API version #documentation
  - Add webhook installation instructions #documentation
  - Create user guide with examples #documentation
```

## Architecture Decisions

```l
decision-log:
  Record of significant architectural choices.

decision-1-operator-framework:
  choice: kubebuilder
  rationale: industry standard, good documentation, active community
  alternatives-considered:
    operator-sdk: more opinionated, less flexible
    from-scratch: too much boilerplate
  date: 2025-11-01

decision-2-storage-abstraction:
  choice: interface-based with pluggable backends
  rationale: supports multiple cloud providers, testable with mocks
  alternatives-considered:
    s3-only: too limiting for multi-cloud users
    separate-operators: operational overhead
  date: 2025-11-03

decision-3-validation-approach:
  choice: both webhook and reconciler validation
  rationale: defense in depth, webhook prevents bad data, reconciler handles edge cases
  alternatives-considered:
    webhook-only: single point of failure
    reconciler-only: allows invalid resources to be created
  date: 2025-11-05

decision-4-backup-execution:
  choice: kubernetes jobs for backup execution
  rationale: native k8s resource, automatic retry, observable in kubectl
  alternatives-considered:
    in-controller: operator becomes stateful
    external-service: additional deployment complexity
  date: 2025-11-02
```

## Next Steps

```l
immediate-priorities:
  Critical issues blocking progress.

  1. Fix controller panic #critical
    Add validation webhook by end of day.
    Enables testing of other features.

  2. Complete reconciliation loop #core
    Needed for basic functionality demo.
    Target: end of week.

  3. Implement S3 backend #storage
    First storage provider, validates interface design.
    Target: next week.

upcoming-work:
  After immediate priorities cleared.

  - Complete integration test suite #testing
  - Add metrics and dashboards #observability
  - Write deployment documentation #documentation
  - Prepare demo for stakeholders #presentation

future-enhancements:
  Not planned for current iteration.

  -? Restore functionality
    Separate controller for managing restores.
    Could reuse storage backends.

  -? Multi-cluster backups
    Backup resources across multiple clusters.
    Requires cluster federation support.

  -? Backup scheduling optimizations
    Smart scheduling based on database load.
    Machine learning for optimal backup windows.
```

## Summary

```l
project-status:
  Complex Kubernetes operator development in progress.

  completed:
    CRD design and implementation.
    Basic controller scaffolding.
    Project structure and tooling.

  in-progress:
    Reconciliation loop implementation.
    Critical bug fix for validation.

  blocked:
    Integration testing (waiting for bug fix).
    Storage backend (waiting for core reconciler).

  next-milestone:
    Working operator with S3 backend.
    Deployed to staging environment.
    Basic functionality validated.

lessons-learned:
  Always add validation at API boundary.
  Defense in depth prevents cascading failures.
  Integration tests reveal issues unit tests miss.
  Clear architecture decisions prevent rework.
```
