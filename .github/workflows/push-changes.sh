#!/usr/bin/env bash

set -eu

git config --local user.name "$GITHUB_ACTOR"
git config --local user.email "$GITHUB_ACTOR@users.noreply.github.com"
#git config --local --unset-all "http.https://github.com/.extraheader" || true

readonly anyChangesDone=$(git status --porcelain)
if [[ -n "${anyChangesDone}" ]]; then
    git add "$1"
    git commit -m "$2"
    git pull -s ours origin main || true
    git push origin main:main
else
    echo Nothing to push
fi
