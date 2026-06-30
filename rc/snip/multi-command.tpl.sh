#!/usr/bin/env bash
# DESCRIPTION
set -eu

################################################################################
# Global vars

SCRIPT_DIR_PATH="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
declare -r SCRIPT_DIR_PATH
SCRIPT_FILE_NAME="$(basename "$0")"
declare -r SCRIPT_FILE_NAME
declare -r SCRIPT_FILE_PATH="$SCRIPT_DIR_PATH/$SCRIPT_FILE_NAME"

declare -r DEFAULT_CMD=help

################################################################################
# Local functions (underscore prefix = hidden from sub-commands)

# _helper() {
#     echo "private"
# }

################################################################################
# Sub-commands (lowercase, no underscore = public)

do-something() {
    # Short description shown in help
    echo "example sub-command"
}

################################################################################
# Sub-command processing

cmd_re() {
    grep -P '^[0-9a-z].*\(\)\s+{' "$SCRIPT_FILE_PATH" | grep -vP '[_A-Z]' | tr -d '() {' | tr '\n' '|' | sed 's/|$//' | sed 's/^/(/' | sed 's/$/)/'
}

help() {
    echo "Usage: $0 \$cmd"
    # shellcheck disable=SC2016
    echo '    where $cmd is one of:'
    cmd_re | perl -WpE 's/[|()]/\n/g' | perl -WpE 's/^/        /' | perl -WnE 'print unless m/^\s*$/'
}

if [[ $# -lt 1 ]]; then
    ${DEFAULT_CMD-help} 1>&2
    exit 1
fi

if [[ ! "$1" =~ ^$(cmd_re)$ ]]; then
    help
    exit 1
fi

"$@"
