package gmail.ebeletskiy.routememorizer.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Photo {

  @Expose private long height;
  @Expose private double latitude;
  @Expose private double longitude;
  @SerializedName("owner_id") @Expose private long ownerId;
  @SerializedName("owner_name") @Expose private String ownerName;
  @SerializedName("owner_url") @Expose private String ownerUrl;
  @SerializedName("photo_file_url") @Expose private String photoFileUrl;
  @SerializedName("photo_id") @Expose private long photoId;
  @SerializedName("photo_title") @Expose private String photoTitle;
  @SerializedName("photo_url") @Expose private String photoUrl;
  @SerializedName("upload_date") @Expose private String uploadDate;
  @Expose private long width;

  /**
   * @return The height
   */
  public long getHeight() {
    return height;
  }

  /**
   * @param height The height
   */
  public void setHeight(long height) {
    this.height = height;
  }

  /**
   * @return The latitude
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * @param latitude The latitude
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * @return The longitude
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * @param longitude The longitude
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * @return The ownerId
   */
  public long getOwnerId() {
    return ownerId;
  }

  /**
   * @param ownerId The owner_id
   */
  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  /**
   * @return The ownerName
   */
  public String getOwnerName() {
    return ownerName;
  }

  /**
   * @param ownerName The owner_name
   */
  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  /**
   * @return The ownerUrl
   */
  public String getOwnerUrl() {
    return ownerUrl;
  }

  /**
   * @param ownerUrl The owner_url
   */
  public void setOwnerUrl(String ownerUrl) {
    this.ownerUrl = ownerUrl;
  }

  /**
   * @return The photoFileUrl
   */
  public String getPhotoFileUrl() {
    return photoFileUrl;
  }

  /**
   * @param photoFileUrl The photo_file_url
   */
  public void setPhotoFileUrl(String photoFileUrl) {
    this.photoFileUrl = photoFileUrl;
  }

  /**
   * @return The photoId
   */
  public long getPhotoId() {
    return photoId;
  }

  /**
   * @param photoId The photo_id
   */
  public void setPhotoId(long photoId) {
    this.photoId = photoId;
  }

  /**
   * @return The photoTitle
   */
  public String getPhotoTitle() {
    return photoTitle;
  }

  /**
   * @param photoTitle The photo_title
   */
  public void setPhotoTitle(String photoTitle) {
    this.photoTitle = photoTitle;
  }

  /**
   * @return The photoUrl
   */
  public String getPhotoUrl() {
    return photoUrl;
  }

  /**
   * @param photoUrl The photo_url
   */
  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  /**
   * @return The uploadDate
   */
  public String getUploadDate() {
    return uploadDate;
  }

  /**
   * @param uploadDate The upload_date
   */
  public void setUploadDate(String uploadDate) {
    this.uploadDate = uploadDate;
  }

  /**
   * @return The width
   */
  public long getWidth() {
    return width;
  }

  /**
   * @param width The width
   */
  public void setWidth(long width) {
    this.width = width;
  }

  @Override public String toString() {
    return "Photo{" +
        "height=" + height +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        ", ownerId=" + ownerId +
        ", ownerName='" + ownerName + '\'' +
        ", ownerUrl='" + ownerUrl + '\'' +
        ", photoFileUrl='" + photoFileUrl + '\'' +
        ", photoId=" + photoId +
        ", photoTitle='" + photoTitle + '\'' +
        ", photoUrl='" + photoUrl + '\'' +
        ", uploadDate='" + uploadDate + '\'' +
        ", width=" + width +
        '}';
  }
}


