package DbContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import DbModel.Creditcard;

public class dbCreditcards extends dbContext {
	public static final String id_col = "id";
	public static final String first_name_col = "first_name";
	public static final String last_name_col = "last_name";
	public static final String expiration_col = "expiration";
	public static final String table_name = "creditcards";
	
	public dbCreditcards(String setting){
		super(setting);
		this.tableName = dbCreditcards.table_name;
	}
	
	public Creditcard GetCreditcard(String card_id){
		try{
			String selectQuery = String.format("select * from %s where id = '%s'", this.tableName, card_id);
			PreparedStatement ps = sqlConnection.prepareStatement(selectQuery);
			ResultSet r = ps.executeQuery();
			Creditcard c = null;
		    while (r.next())
		    {
		    	c = new Creditcard();
		    	c.cc_id = r.getString(dbCreditcards.id_col);
		    	c.first_name = r.getString(dbCreditcards.first_name_col);
		    	c.last_name = r.getString(dbCreditcards.last_name_col);
		    	c.expiration = r.getDate(dbCreditcards.expiration_col).toString();
		    }
		    r.close();
		    ps.close();
		    sqlConnection.close();
		    return c;
		}
		catch(Exception e){
			System.out.println("Error occured, credit card does not exist");
			return null;
		}
		
		
	}
	
	public Creditcard GetCreditcard(String id, String first_name, String last_name, String expiration)
	{
		try{
			first_name = first_name == null ? "" : first_name;
			last_name = last_name == null ? "" : last_name;
			id = id == null ? "" : id;
			expiration = expiration == null ? "" : expiration;
			String selectQuery = String.format("select * from %s where id = '%s' and first_name = '%s' and last_name = '%s' and expiration = '%s'",
												this.tableName, id, first_name, last_name, expiration);
			PreparedStatement ps = sqlConnection.prepareStatement(selectQuery);
			ResultSet r = ps.executeQuery();
			Creditcard c = null;
			while (r.next())
		    {
		    	c = new Creditcard();
		    	c.cc_id = r.getString(dbCreditcards.id_col);
		    	c.first_name = r.getString(dbCreditcards.first_name_col);
		    	c.last_name = r.getString(dbCreditcards.last_name_col);
		    	c.expiration = r.getDate(dbCreditcards.expiration_col).toString();
		    }
			ps.close();
			r.close();
			sqlConnection.close();
			return c;
		}
		catch(Exception e){
			System.out.println("Error occured, credit card does not exist");
			return null;
		}
	
	}
}
