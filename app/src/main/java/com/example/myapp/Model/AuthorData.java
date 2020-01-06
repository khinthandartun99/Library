package com.example.myapp.Model;

import java.io.Serializable;

public class AuthorData implements Serializable {
    String authorname;

    public AuthorData(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorName() {
        return authorname;
    }
}
