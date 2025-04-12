#!/usr/bin/env bash

set -eu

detect-distro() {
    :
}

detect-pkg-manager() {
    local exes=()
    for exe in pacman apt apt-get aptitude dnf yum rpm apk; do    
      if isExe $exe; then
        exes+=($exe)
      Fi
    done
   if isExe snap && isExe snapd; then
       exes+=(snap)
   fi
   echo ( IFS=$'\n'; echo "${exes[*]}" | sort )
}

detect-firmware() {
  # todo
  ls /sys/firmware/efi/efivars
}

#####
# private

isExe() {
    command -v "$@" > /dev/null
}

