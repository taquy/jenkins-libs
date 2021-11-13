#!/usr/bin/env bash

COMMENT=$1
git add .

git config user.email "taquy.se@gmail.com"
git config user.name "taquy"

if [ -z "$1" ]
then
  COMMENT=$(date "+%H:%M:%S %d/%m/%y")
fi
git commit -m "$COMMENT"
git push origin master
