package com.epf.core.Model;

public class Maps {
    private Integer idMap;
    private Integer ligne;
    private Integer colonne;
    private String chemin_image;

    public Maps(Integer idMap, Integer ligne, Integer colonne, String chemin_image) {
        this.idMap = idMap;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public Maps() {

    }

    public Integer getIdMap() {
        return idMap;
    }

    public void setIdMap(Integer idMap) {
        this.idMap = idMap;
    }

    public Integer getLigne() {
        return ligne;
    }

    public Integer getColonne() {
        return colonne;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setLigne(Integer ligne) {
        this.ligne = ligne;
    }

    public void setColonne(Integer colonne) {
        this.colonne = colonne;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

}
