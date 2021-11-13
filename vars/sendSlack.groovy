#!/usr/bin/env groovy
def call() {
    BUILD_MESSAGE = "${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}>"
    message = "Build ${status} - ${BUILD_MESSAGE}"
    String color = 'good'
    switch (status) {
        case 'failed':
        case 'unsuccessful':
            color = 'danger'
        break
        case 'started':
            color = 'warning'
        break
    }
    slackSend(
        teamDomain: SLACK_DOMAIN,
        channel: SLACK_CHANNEL,
        tokenCredentialId: SECRET_SLACK_TOKEN,
        color: color,
        message: message
    )
}