package Model;

import java.io.Serializable;
import java.sql.Date;

/*
	[MODEL] Mappatura delle seguenti tabelle:
	- {TRANSACTIONS}

    Sfrutta gli ID di {USERS} e {GAMES}. La data viene salvata in formato YYYY-MM-DD (ref. java.sql.Date).

    Lo storico delle transazioni viene stampato esclusivamente nella pagina delle impostazioni.
*/
public class Transaction implements Serializable {

	private static final long serialVersionUID = -9122194956940676063L;
    
    private User user;
    private Game game;
    private Date transaction_date;
    private int transaction_price; // Mantiene il prezzo originale della transazione, in caso il prezzo del gioco cambi nel tempo

    public Transaction(User user, Game game, Date transaction_date, int transaction_price) {
        this.user = user;
        this.game = game;
        this.transaction_date = transaction_date;
        this.transaction_price = transaction_price;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Date getTransaction_date() {
        return this.transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getTransaction_price() {
        return this.transaction_price;
    }

    public void setTransaction_price(int transaction_price) {
        this.transaction_price = transaction_price;
    }

}
