#!/bin/bash
ps -ef|grep gitbook-publish-autoscript-1.0-SNAPSHOT.jar|grep -v grep|awk '{print $2}'|xargs kill -9