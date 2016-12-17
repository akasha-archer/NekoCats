package nyc.c4q.akashaarcher.nekocats.model;

import android.support.annotation.DrawableRes;

/**
 * Created by Akasha on 12/15/16.
 */

public class Cat {

    private Long _id;
    private String catNumber;
    private Integer catImage;


    public Cat(String catNumber, @DrawableRes Integer resource) {
        this.catNumber = catNumber;
        this.catImage = resource;
    }

    public Long getId() {
        return _id;
    }

    public String getCatNumber() {
        return catNumber;
    }

    public void setCatNumber(String catNumber) {
        this.catNumber = catNumber;
    }

    public Integer getCatImage() {
        return catImage;
    }

    public void setCatImage(Integer catImage) {
        this.catImage = catImage;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catNumber='" + catNumber + '\'' +
                ", catImage='" + catImage + '\'' +
                '}';
    }
}
