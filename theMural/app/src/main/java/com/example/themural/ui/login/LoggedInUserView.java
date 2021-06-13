package com.example.themural.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String nickName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String nickName) {
        this.nickName = nickName;
    }

    String getDisplayName() {
        return nickName;
    }
}