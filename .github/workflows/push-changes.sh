#!/usr/bin/env bash

set -eu

#git config --local --unset-all "http.https://github.com/.extraheader" || true

if [[ -n "$(git status --porcelain)" ]]; then
    git config --local user.name "$GITHUB_ACTOR"
    git config --local user.email "$GITHUB_ACTOR@users.noreply.github.com"
    git add -A
    git commit -m "$1"
    git pull -s ours origin main || true
    git push origin main:main
else
    echo Nothing to push
fi
