#include <stdarg.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

extern void morpho_err(const char *fmt, ...) {
    //puts(msg);
    va_list args;
    va_start(args, fmt);
    //fprintf(stderr, "fopen() failed in file %s at line # %d", __FILE__,__LINE__);
    vfprintf(stderr, fmt, args);
    fputc ('\n', stderr);
    va_end(args);
    _exit(EXIT_FAILURE); // see notes in systemd sources about exit()
}
