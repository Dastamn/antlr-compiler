package com.dastamn.antlrcompiler.entities;

public enum Library {

        LANG("Small_Java.lang"),
        IO("Small_Java.io");

        private String name;

        Library(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }

    }
