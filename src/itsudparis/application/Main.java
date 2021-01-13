/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itsudparis.application;

import java.util.Scanner;

import com.hp.hpl.jena.rdf.model.Model;

import itsudparis.tools.JenaEngine;
/**
 * @author DO.ITSUDPARIS
 */
public class Main {
	
	public static final String ns = "<http://www.semanticweb.org/nada/ontologies/2019/11/untitled-ontology-10>";
	public static String inputDataOntology = "data/smart_home.owl";
    public static String inputRule = "data/rules.txt";
	
	
	/**
	 * @param args
	 * the command line arguments
	 */
	public static void main(String[] args) {
	
	

		
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel(inputDataOntology);
        
		if (model != null) {
			
			// appliquer les règles sur le modèle
			Model owlInferencedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/owlrules.txt");
			Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(owlInferencedModel,inputRule);
			
			
			String query_time = JenaEngine.executeQueryFile(inferedModel, "data/query_time.txt");
			System.out.println(query_time);
			
			// afficher la composition de la maison 
			

		
			
			// effectuer les requêtes
			
			String query_night=  JenaEngine.executeQueryFile(inferedModel, "data/query_night.txt");
			String query_morning=  JenaEngine.executeQueryFile(inferedModel, "data/query_morning.txt");
			String query_humid = JenaEngine.executeQueryFile(inferedModel, "data/query_humid.txt");
			String query_sec = JenaEngine.executeQueryFile(inferedModel, "data/query_sec.txt");
			String query_nrml = JenaEngine.executeQueryFile(inferedModel, "data/query_humid_normal.txt");
			String query_hot = JenaEngine.executeQueryFile(inferedModel, "data/query_hot.txt");
			String query_cold = JenaEngine.executeQueryFile(inferedModel, "data/query_cold.txt");
			String query_lum = JenaEngine.executeQueryFile(inferedModel, "data/query_luminosity.txt");
			String query_dark = JenaEngine.executeQueryFile(inferedModel, "data/query_dark.txt");
			String query = JenaEngine.executeQueryFile(inferedModel, "data/query.txt");
			String query_lum_normal = JenaEngine.executeQueryFile(inferedModel, "data/query_lum_normal.txt");
			String query_temp_normal = JenaEngine.executeQueryFile(inferedModel, "data/query_normal_temp.txt");
			
			System.out.println("L'appartement se compose de : ");
			System.out.println(query);
			
			if(query_night.contains("\"")) {
				System.out.println("il est soir!! Il faut fermer les volets!!");
			}
				
				
			if(query_morning.contains("\"")) {
				System.out.println("il est matin!! Il faut ouvrir les volets pour aéerer la chambre!!");
			}
			
			if(query_humid.contains("\"")) {
				System.out.println("Ouvrir le chauffage  pour les pièces suivantes ");
				System.out.println(query_humid);		
			}
			
			if(query_sec.contains("\"")) {
			System.out.println("Fermer les volets pour les pièces suivantes");
			System.out.println(query_sec);
			}
			
			if(query_nrml.contains("\"")) {
			System.out.println("Les piéces d'humidité normale : ");
			System.out.println(query_nrml);
			}
			
			if(query_cold.contains("\"")) {
			System.out.println("Ouvrir le chauffage et fermer les volets  pour les pièces suivantes" );
			System.out.println(query_cold);
			}
			
			if(query_hot.contains("\"")) {
			System.out.println("Climatiser les pièces suivantes" );
			System.out.println(query_hot);
			}
			
			if(query_temp_normal.contains("\"")) {
			System.out.println("Les piéces de temperatre normale" );
			System.out.println(query_temp_normal);
			}
			if(query_lum.contains("\"")) {
			System.out.println("La luminosité  des pièces suivantes" );
			System.out.println(query_lum);
			}
			
			if(query_dark.contains("\"")) {
			System.out.println("Allumer les lampes pour les pieces suivantes" );
			System.out.println(query_dark);
			}
			
			if(query_lum_normal.contains("\"")) {
			System.out.println("Les piéces de luminosité normale " );
			System.out.println(query_lum_normal);
			}
			
		
		} else 
		{
			System.out.println("erreur lors de la lecture de l'ontologie");
		}
	
}
}