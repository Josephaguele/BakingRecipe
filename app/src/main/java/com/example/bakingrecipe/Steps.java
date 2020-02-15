package com.example.bakingrecipe;

class Steps {

    private int id;
    private String shortDescription;
    private String description;
    private String videoUrl;
    private String thumbnailUrl;

    public Steps(int stepID, String shortDesc, String desc, String vidUrl, String thumbNUrl){
        id = stepID;
        shortDescription = shortDesc;
        description = desc;
        videoUrl = vidUrl;
        thumbnailUrl = thumbNUrl;
    }

    public int getId(){
        return id;
    }

    public String getShortDescription(){
        return shortDescription;
    }

    public String getDescription(){
        return description;
    }

    public String getVideoUrl(){
        return videoUrl;
    }

    public String getThumbnailUrl(){
        return thumbnailUrl;
    }
}
