package models;

import io.ebean.Finder;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class ProfilePic extends BaseModel{
    @Lob
    public byte[] pic;

    public static Finder<Long, ProfilePic> find = new Finder<>(ProfilePic.class);



}