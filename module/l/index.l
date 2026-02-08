checklist: `AND`ed given-when-then-because checks

flow: executable cell
  input: any
  output: any
  pre-conditions: checklist
  post-conditions: checklist
  invariants: checklist
  steps: loop (>= 1)
    Algorithm, transforming input to output