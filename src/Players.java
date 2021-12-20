package src;

import java.util.ArrayList;

public class Players {
    //  Liste de joueurs
    private ArrayList<Player> players;

    public Players() {
        this.players = new ArrayList<Player>();
    }

    //  Accesseur en lecture permettant de récupérer le joueur d'index i dans players
    public Player getPlayer(byte i) {
        return this.players.get(i);
    }

    //  Accesseur en lecture permettant de récupérer la taille de players
    public byte getSize() {
        return (byte)this.players.size();
    }

    //  Ajout d'un joueur dans players
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    //  Suppression d'un joueur dans player
    public void removePlayer(String pseudo) {
        byte i;

        for (i = 0; i < this.getSize(); i++) {
            if (this.getPlayer(i).getPseudo().equals(pseudo))
                this.players.remove(this.getPlayer(i));
        }
    }

    //  Réinitialisation de tous les joueurs dans player
    public void reset() {
        byte i;

        if (this.getSize() != 0) {
            for (i = 0; i < this.getSize(); i++)
                this.getPlayer(i).reset();
        }
    }

    @Override
    public String toString() {
        byte size;
        byte i;
        String str;

        size = this.getSize();
        str = "";
        for (i = 0; i < size; i++) {
            str += this.getPlayer(i);
            str += i < size ? '\n' : "";
        }
        return str;
    }

    //  Retourne true si le joueur existe
    public boolean existingPlayer(String pseudo) {
        byte i;

        for (i = 0; i < this.getSize(); i++) {
            if (this.getPlayer(i).getPseudo().equals(pseudo))
                return true;
        }
        return false;
    }
}
