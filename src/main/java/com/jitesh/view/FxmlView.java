package com.jitesh.view;

import java.util.ResourceBundle;

public enum FxmlView {

    ADMIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("Admin.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Admin.fxml";
        }
    },
    Category {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Category.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Category.fxml";
        }
    },
    AddCategory {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Category.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/category/Add.fxml";
        }
    },
    EditCategory {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Category.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/category/Edit.fxml";
        }
    },
    LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
