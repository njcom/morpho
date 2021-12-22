    .data

hello_str:
    .string "Hello, 64-bit world!\n"
 
    // Calculation string length and saving it as symbol hello_str_length. `-1` is necessary to ignore \x00 adding by .string
    .set hello_str_length, . - hello_str - 1

    .text
    .globl  _start

_start:
    mov    $1, %rax                // syscall number: write()
    mov    $1, %rdi                // 1 arg: file descriptor, 1 is stdin
    mov    $hello_str, %rsi        // 2 arg: address of string
    mov    $hello_str_length, %rdx // 3 arg: lenght of string in bytes
    syscall

    movq    $60, %rax              // syscall number: exit()
    movq    $0, %rdi               // 1 arg: exit code
    syscall
