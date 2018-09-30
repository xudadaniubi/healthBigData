package com.boku.www.pojo;

public class TMenu {
    private String menuId;

    private String menuName;

    private String menuPage;

    private String menuPriority;

    private String menuDescription;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuPage() {
        return menuPage;
    }

    public void setMenuPage(String menuPage) {
        this.menuPage = menuPage == null ? null : menuPage.trim();
    }

    public String getMenuPriority() {
        return menuPriority;
    }

    public void setMenuPriority(String menuPriority) {
        this.menuPriority = menuPriority == null ? null : menuPriority.trim();
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription == null ? null : menuDescription.trim();
    }
}