/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import DAO.UsuarioDAO;

/**
 *
 * @author DeusBets
 */
public class Globals {

    private static Globals inst;
    private int idUsuario;
    private String nickname;

    private Globals(int usr_id) {
        setIdUsuario(usr_id);
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        UsuarioDAO dao = new UsuarioDAO();
        this.idUsuario = idUsuario;

        this.nickname = dao.GetNicknameById(idUsuario);
    }

    public String getNickname() {
        return nickname;
    }

    public static Globals getInstance(int usr_id) {
        if (inst == null) {
            inst = new Globals(usr_id);
        }

        return inst;
    }
}
