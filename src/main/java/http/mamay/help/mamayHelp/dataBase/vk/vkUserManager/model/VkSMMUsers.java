package http.mamay.help.mamayHelp.dataBase.vk.vkUserManager.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class VkSMMUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne(orphanRemoval = true)
    private VkUser user;
    @ManyToOne(optional = true)
    private VkGroup group;
    @Transient
    private LocalDate dateAdded;
    @Transient
    private Boolean isSubscrible;
    @Transient
    private Boolean invitedToFriend;
    @Transient
    private Boolean saveAsFriend;
    @Transient
    private Boolean invitedToGroup;
    @Transient
    private Boolean entered;
    @Transient
    private Boolean deleted;

    public VkSMMUsers() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VkUser getUser() {
        return user;
    }

    public void setUser(VkUser user) {
        this.user = user;
    }

    public VkGroup getGroup() {
        return group;
    }

    public void setGroup(VkGroup group) {
        this.group = group;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Boolean getSubscrible() {
        return isSubscrible;
    }

    public void setSubscrible(Boolean subscrible) {
        isSubscrible = subscrible;
    }

    public Boolean getInvitedToFriend() {
        return invitedToFriend;
    }

    public void setInvitedToFriend(Boolean invitedToFriend) {
        this.invitedToFriend = invitedToFriend;
    }

    public Boolean getSaveAsFriend() {
        return saveAsFriend;
    }

    public void setSaveAsFriend(Boolean saveAsFriend) {
        this.saveAsFriend = saveAsFriend;
    }

    public Boolean getInvitedToGroup() {
        return invitedToGroup;
    }

    public void setInvitedToGroup(Boolean invitedToGroup) {
        this.invitedToGroup = invitedToGroup;
    }

    public Boolean getEntered() {
        return entered;
    }

    public void setEntered(Boolean entered) {
        this.entered = entered;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
