package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Ville;

public class VilleDAO {
	
	final static String SQL_SELECT_VILLES = "SELECT * FROM ville_france" ;
	final static String SQL_INSERT_VILLE = "INSERT INTO ville_france VALUES(" ;
	
	private static String URL = "jdbc:mysql://localhost/integrationweb";
    private static String LOGIN = "root";
    private static String PASSWORD = "";
    
    public static List<Ville> trouverVilles(){
    	List<Ville> villes = new ArrayList<Ville>();
	    Connection con = null;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = con.createStatement();
		    ResultSet rset = stmt.executeQuery(SQL_SELECT_VILLES);
		    
		    while(rset.next()) {
		    	final Ville ville = rsetToVille(rset);
		    	villes.add(ville) ;
		    }
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
    }
    
    public static List<Ville> trouverVille(String nomVille){
    	List<Ville> villes = new ArrayList<Ville>();
	    Connection con = null;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = con.createStatement();
		    ResultSet rset = stmt.executeQuery(SQL_SELECT_VILLES+" WHERE Nom_commune="+nomVille+";");
		    
		    while(rset.next()) {
		    	final Ville ville = rsetToVille(rset);
		    	villes.add(ville) ;
		    }
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
    }
    
    private static Ville rsetToVille(final ResultSet rset) throws SQLException {
        final String codeCommuneINSEE = rset.getString("Code_commune_INSEE");
        final String nomCommune = rset.getString("Nom_commune");
        final String codePostal = rset.getString("Code_postal");
        final String libelleAcheminement = rset.getString("Libelle_acheminement");
        final String ligne5 = rset.getString("Ligne_5");
        final String lattitude = rset.getString("Latitude");
        final String longitude = rset.getString("Longitude");

        final Ville ville = new Ville(codeCommuneINSEE, nomCommune, codePostal, libelleAcheminement, ligne5, lattitude, longitude);
        return ville;
    }
    
    public static void ajouterVille(Ville ville) {
    	Connection con = null;
    	
    	try {
	    	con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(SQL_INSERT_VILLE+ville.getCodeCommuneINSEE()+","+ville.getNomCommune()+","+ville.getCodePostal()+","+
			ville.getLibelleAcheminement()+","+ville.getLigne5()+","+ville.getLattitude()+","+ville.getLongitude()+")");
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    }
}
    
