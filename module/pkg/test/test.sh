#!/usr/bin/env bash

set -eu

readonly SCRIPT_FILE_NAME="$(basename "$0")"
readonly SCRIPT_DIR_PATH="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
readonly SCRIPT_FILE_PATH="$SCRIPT_DIR_PATH/$SCRIPT_FILE_NAME"

source $SCRIPT_DIR_PATH/../dst/pkg

test-is-exe() {

}