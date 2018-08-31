package com.cvbank.model;

public class Views {
    // show only public data
    public interface Public {}

    // show public and internal data
    public interface Internal extends Public {}
}

