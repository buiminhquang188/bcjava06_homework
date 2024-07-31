package org.cybersoft.capstone.entity;

public class UsersProjectEntity {
    private Integer id;
    private Integer idUser;
    private Integer idProject;

    public UsersProjectEntity() {
    }

    public UsersProjectEntity(Integer id, Integer idUser, Integer idProject) {
        this.id = id;
        this.idUser = idUser;
        this.idProject = idProject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }
}
