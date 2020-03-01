package com.haqueit.shaitolawelfare.qrscanning;

public class CardModel {
    private String card_name="";
    private String card_number="";
    private String card_type="";
    private String card_validity="";
    private String card_cvv="";
    private int icon;

    public CardModel(String card_name, String card_number, String card_type, String card_validity, int icon,String card_cvv) {
        this.card_name = card_name;
        this.card_number = card_number;
        this.card_type = card_type;
        this.card_validity = card_validity;
        this.icon = icon;
        this.card_cvv = card_cvv;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_validity() {
        return card_validity;
    }

    public void setCard_validity(String card_validity) {
        this.card_validity = card_validity;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }
}
