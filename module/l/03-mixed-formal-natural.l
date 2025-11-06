# Mixed Formal and Natural Language Examples

## Example 1: System Design with Commentary

```l
authentication-system:
  A comprehensive authentication system for web applications.

  We need to support multiple authentication methods while maintaining security.
  The system should be extensible for future authentication providers.

  components:
    token-service: handles JWT token generation and validation
    session-store: manages active user sessions
    auth-middleware: validates requests before processing
    provider-interface: abstraction for authentication methods

  providers:
    local: username and password authentication
    oauth2: third-party authentication
    saml: enterprise SSO integration

token-service:
  Core service for JWT operations.

  configuration:
    signing-algorithm: hs256
    token-expiry: 3600
    refresh-expiry: 86400
    issuer: auth-service
    secret-source: environment-variable

  operations:
    generate-token: user-claims -> jwt-token
    validate-token: jwt-token -> user-claims | error
    refresh-token: refresh-token -> jwt-token | error

  The `generate-token` function creates a signed JWT with user claims.
  Claims include user ID, role, and expiration timestamp.

  Security considerations:
  We use HS256 for simplicity but should migrate to RS256 for production.
  Refresh tokens stored in secure HTTP-only cookies.
  Token rotation on each refresh to prevent replay attacks.

session-store:
  In-memory or Redis-backed session storage.

  interface:
    create-session: user-id -> session-id
    get-session: session-id -> session-data | none
    delete-session: session-id -> unit
    cleanup-expired: unit -> count

  implementation-choice:
    development: in-memory with map structure
    production: redis with automatic expiration

    redis-config:
      host: from environment
      port: 6379
      db: 0
      key-prefix: session:
      ttl: 86400

  Memory store is suitable for development but won't scale.
  Redis provides persistence and works across multiple instances.

auth-middleware:
  Express.js middleware for request authentication.

  Pseudocode for middleware logic:
  ```
  function authenticate(request, response, next):
    token = extract-token request
    if token is none:
      return unauthorized-response

    claims = validate-token token
    if claims is error:
      return unauthorized-response

    request.user = claims
    next()
  ```

  The middleware extracts the JWT from the Authorization header.
  It validates the token signature and expiration.
  Valid requests get user claims attached for downstream handlers.

  Error handling:
  - Missing token: 401 Unauthorized
  - Invalid signature: 401 Unauthorized
  - Expired token: 401 Unauthorized with refresh hint
  - Malformed token: 400 Bad Request
```

## Example 2: Problem Analysis with Formal Models

```l
database-performance-issue:
  Investigation of slow queries in production database.

-!! User search endpoint timing out #performance, #database, #critical
  Endpoint response time: 5-10 seconds (target: <200ms).
  Affects user search feature used by 80% of users.

investigation-steps:
  + Enable query logging #investigation
    Logged all queries over 1 second.

  + Analyze query patterns #investigation
    Found pattern: SELECT * FROM users WHERE email LIKE '%search%'

  + Check database indexes #investigation
    discovered-issue:
      No index on users.email column.
      Sequential scan on 500k row table.

  query-plan-before:
    Seq Scan on users (cost=0.00..12500.00 rows=500000 width=256)
    Filter: (email ~~ '%search%'::text)
    Planning Time: 0.123 ms
    Execution Time: 5234.567 ms

root-cause:
  Missing database index on frequently searched column.

  Why wasn't this caught earlier?
  - No performance testing with realistic data volume.
  - Test database only had 100 rows.
  - Query worked fine in development.

  This demonstrates importance of testing with production-like data.

solution:
  + Create index on users.email #fix
    ```sql
    CREATE INDEX CONCURRENTLY idx_users_email
    ON users USING btree (email);
    ```

  + Verify query plan improved #verification
    query-plan-after:
      Index Scan using idx_users_email on users
      (cost=0.42..8.44 rows=5 width=256)
      Index Cond: (email = 'search@example.com'::text)
      Planning Time: 0.234 ms
      Execution Time: 2.345 ms

    Performance improvement: 5234ms -> 2ms (2617x faster).

  Additional optimizations considered:
  - Add full-text search index for better LIKE performance
  - Implement search result caching
  - Add pagination to limit result set size

  -? Implement full-text search #optimization
    Would enable more sophisticated search queries.
    Requires migration to use tsvector type.
    Benefit unclear for current use case.

lessons-learned:
  Always test with production-scale data.
  Monitor query performance in production.
  Index frequently searched columns.
  Use EXPLAIN ANALYZE to diagnose slow queries.
```

## Example 3: API Design with Multiple Languages

```l
rest-api-design:
  RESTful API for user management service.

  We follow REST conventions with JSON payloads.
  Authentication via JWT in Authorization header.

endpoints:
  User management:
    GET    /api/users          list users with pagination
    GET    /api/users/:id      get specific user
    POST   /api/users          create new user
    PUT    /api/users/:id      update existing user
    DELETE /api/users/:id      delete user

  Authentication:
    POST   /api/auth/login     authenticate and get token
    POST   /api/auth/refresh   refresh access token
    POST   /api/auth/logout    invalidate session

user-resource:
  JSON representation of user entity.

  ```json
  {
    "id": "uuid-v4-string",
    "username": "string",
    "email": "string",
    "role": "admin | user | guest",
    "created_at": "iso8601-timestamp",
    "updated_at": "iso8601-timestamp"
  }
  ```

  Field constraints:
  - username: 3-30 characters, alphanumeric and underscore only
  - email: valid email format, unique across system
  - role: one of allowed values

create-user-endpoint:
  POST /api/users

  Request payload:
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string",
    "role": "user"
  }
  ```

  Response on success (201 Created):
  ```json
  {
    "id": "generated-uuid",
    "username": "provided-username",
    "email": "provided-email",
    "role": "user",
    "created_at": "2025-11-06T12:00:00Z",
    "updated_at": "2025-11-06T12:00:00Z"
  }
  ```

  Response on validation error (400 Bad Request):
  ```json
  {
    "error": "validation_error",
    "message": "Invalid input data",
    "details": [
      {
        "field": "email",
        "message": "Email already exists"
      }
    ]
  }
  ```

  Implementation in Go:
  ```go
  func (h *UserHandler) CreateUser(w http.ResponseWriter, r *http.Request) {
    var req CreateUserRequest
    if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
      respondError(w, http.StatusBadRequest, "Invalid JSON")
      return
    }

    if err := h.validator.Validate(req); err != nil {
      respondValidationError(w, err)
      return
    }

    user, err := h.service.CreateUser(r.Context(), req)
    if err != nil {
      respondError(w, http.StatusInternalServerError, "Failed to create user")
      return
    }

    respondJSON(w, http.StatusCreated, user)
  }
  ```

  The handler follows standard pattern:
  1. Decode request payload
  2. Validate input
  3. Call service layer
  4. Return appropriate response

  Error handling ensures all errors logged and appropriate status codes returned.

authentication-flow:
  Sequence diagram for login flow.

  ```
  Client -> API: POST /api/auth/login {username, password}
  API -> Service: authenticate(username, password)
  Service -> Database: get-user-by-username(username)
  Database -> Service: user-record
  Service -> Service: verify-password(password, user.password_hash)
  Service -> TokenService: generate-token(user.id, user.role)
  TokenService -> Service: {access_token, refresh_token}
  Service -> API: {tokens, user}
  API -> Client: 200 OK {access_token, refresh_token, user}
  ```

  On successful authentication:
  - Access token valid for 1 hour
  - Refresh token valid for 24 hours
  - Refresh token stored in secure HTTP-only cookie
  - Access token returned in response body for client storage

  Security measures:
  - Passwords hashed with bcrypt (cost factor 12)
  - Rate limiting on login endpoint (5 attempts per minute)
  - Account lockout after 10 failed attempts
  - All authentication events logged for audit
```

## Example 4: Mathematical Formalization

```l
algorithm-complexity:
  Analysis of algorithm time and space complexity.

search-algorithms:
  Comparison of search algorithm performance characteristics.

  linear-search:
    algorithm: iterate through array sequentially
    time-complexity: O(n)
    space-complexity: O(1)
    best-case: O(1) when element is first
    worst-case: O(n) when element is last or not present

  binary-search:
    algorithm: divide and conquer on sorted array
    time-complexity: O(log n)
    space-complexity: O(1) iterative, O(log n) recursive
    precondition: array must be sorted
    best-case: O(1) when element is middle
    worst-case: O(log n)

  hash-lookup:
    algorithm: compute hash and access bucket
    time-complexity: O(1) average, O(n) worst case
    space-complexity: O(n) for hash table
    best-case: O(1)
    worst-case: O(n) when all keys hash to same bucket

formal-analysis:
  Binary search correctness proof.

  theorem:
    For sorted array A of length n and target value x,
    binary search returns index i such that A[i] = x, or -1 if x ∉ A.

  invariant:
    At each iteration with bounds [low, high]:
    - If x ∈ A, then x ∈ A[low..high]
    - low ≤ high or x ∉ A

  proof-sketch:
    Base case: low = 0, high = n-1, entire array considered.

    Inductive step:
      Assume invariant holds at iteration k.
      mid = ⌊(low + high) / 2⌋

      Case 1: A[mid] = x
        Return mid. Correct by equality.

      Case 2: A[mid] < x
        Set low = mid + 1.
        Since array sorted and A[mid] < x, if x ∈ A then x ∈ A[mid+1..high].
        Invariant preserved.

      Case 3: A[mid] > x
        Set high = mid - 1.
        Since array sorted and A[mid] > x, if x ∈ A then x ∈ A[low..mid-1].
        Invariant preserved.

      Termination:
        high - low decreases each iteration.
        When low > high, return -1.
        By invariant, x ∉ A.

  This demonstrates formal reasoning embedded in L.
  Mathematical notation used where it clarifies.
```

## Example 5: Task Planning with Dependencies

```l
feature-implementation-plan:
  Plan for implementing real-time notification system.

## Phase 1: Infrastructure Setup

+ Setup Redis for pub/sub #infrastructure, #setup
  redis-config:
    deployment: kubernetes statefulset
    persistence: enabled
    replicas: 3

  Used Helm chart for deployment.
  Configuration stored in ConfigMap.

+ Setup WebSocket server #infrastructure, #setup
  Framework choice: Socket.io for Node.js.
  Handles connection management and message routing.

  server-config:
    port: 3001
    cors: allowed-origins from environment
    transports: [websocket, polling]

## Phase 2: Backend Implementation

- Implement notification service #backend, #core
  Service that publishes notifications to Redis.

  interface:
    send-notification: user-id -> notification -> result

  notification-types:
    message: new chat message
    alert: system alert
    update: data update event

  - Create notification model #backend
    fields:
      id: unique-identifier
      user-id: recipient
      type: notification-type
      payload: json-data
      created-at: timestamp

  - Implement Redis publisher #backend
    Publishes to channel: notifications:{user-id}

  - Add notification triggers #backend
    Hook into existing services:
    - Chat service sends message notifications
    - Alert service sends system alerts
    - Data service sends update events

-! Need to handle notification persistence #backend
  Current implementation doesn't persist notifications.
  If user offline, notifications lost.

  solution-options:
    database-persistence: store in PostgreSQL
    redis-streams: use Redis Streams for durability
    message-queue: use RabbitMQ or Kafka

  -? Choose persistence mechanism
    Evaluate options based on:
    - Durability requirements
    - Query patterns
    - Scalability needs

## Phase 3: WebSocket Integration

- Implement WebSocket handler #websocket, #backend
  Subscribes to Redis channels and forwards to clients.

  connection-lifecycle:
    client-connect -> authenticate -> subscribe-to-channels -> receive-messages -> client-disconnect

  authentication:
    Validate JWT token on connection.
    Extract user ID from token claims.
    Subscribe to user-specific Redis channel.

  ```javascript
  io.on('connection', async (socket) => {
    const token = socket.handshake.auth.token;
    const claims = await validateToken(token);

    if (!claims) {
      socket.disconnect();
      return;
    }

    const userId = claims.userId;
    const channel = `notifications:${userId}`;

    redisClient.subscribe(channel, (message) => {
      socket.emit('notification', JSON.parse(message));
    });

    socket.on('disconnect', () => {
      redisClient.unsubscribe(channel);
    });
  });
  ```

  - Implement connection handler #implementation
  - Add authentication middleware #implementation, #security
  - Handle reconnection logic #implementation
  - Add heartbeat/ping mechanism #implementation

## Phase 4: Frontend Integration

- Implement notification client #frontend, #react
  React hooks for WebSocket connection and notifications.

  hooks:
    useNotifications: () -> notifications[]
    useNotificationCount: () -> count

  ```typescript
  function useNotifications() {
    const [notifications, setNotifications] = useState([]);
    const socket = useWebSocket();

    useEffect(() => {
      socket.on('notification', (notification) => {
        setNotifications(prev => [notification, ...prev]);
      });

      return () => socket.off('notification');
    }, [socket]);

    return notifications;
  }
  ```

  - Create WebSocket context provider #frontend
  - Implement notification hooks #frontend
  - Build notification UI component #frontend, #ui
  - Add notification badge #frontend, #ui

## Testing Strategy

- Unit tests for notification service #testing
  Mock Redis client and verify publish calls.

- Integration tests for WebSocket handler #testing
  Use socket.io-client to simulate connections.

  test-scenarios:
    Valid authentication: connection succeeds
    Invalid authentication: connection rejected
    Message delivery: notification received
    Reconnection: maintains subscription

- E2E tests for full flow #testing
  Complete flow from trigger to UI update.

  test-flow:
    trigger-event -> notification-published -> websocket-receives -> ui-updates

## Dependencies and Blockers

```l
task-dependencies:
  Tasks that depend on other tasks completing first.

  phase-1-complete -> phase-2-start
    Infrastructure must be ready before backend implementation.

  notification-service-complete -> websocket-integration-start
    WebSocket needs notification service to subscribe to.

  backend-complete -> frontend-integration-start
    Frontend needs working backend to test against.

current-blockers:
  -? Persistence mechanism undecided
    Blocks implementation of offline notification delivery.
    Need architecture decision before proceeding.

  -! Redis cluster not in staging
    Can't test pub/sub fully without Redis.
    Workaround: use local Redis for development.
```

## Summary

These examples demonstrate L language patterns:
- Mixing formal specifications with natural explanations
- Task management with states and tags
- Mathematical notation for precise semantics
- Code blocks from multiple languages
- Hierarchical organization with context scoping
- Problem tracking with severity levels
