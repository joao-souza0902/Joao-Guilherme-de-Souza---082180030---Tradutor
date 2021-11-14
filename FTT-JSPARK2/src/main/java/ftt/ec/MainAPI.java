package ftt.ec;

import ftt.ec.controller.Calc;
import ftt.ec.controller.GitHubUser;
import ftt.ec.controller.SafePassword;
import ftt.ec.controller.controller_tradutor;
import java.util.Date;
import spark.Spark;
import static spark.Spark.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonyg
 */
public class MainAPI {
    public static void main(String[] args) {
		System.out.println("FTT-JSPARK2 - " + new Date());
	
		
		Spark.staticFiles.location("public");
		port(8080); //Default - 4567
		
		get("/hello", (req, res) -> "Hello FTT - GET - " + new Date());
		delete("/hello", (req, res) -> "Hello FTT - DELETE - " + new Date());
		post("/hello", (req, res) -> "Hello FTT - POST - " + new Date());
		put("/hello", (req, res) -> "Hello FTT - PUT - " + new Date());
		
		//TODO - Daniel Carvalho - API Senha segura...
	    get("/safepassword", (req,res) -> new SafePassword().getPassword());
	    
	    get("/soma/:a/:b", (req,res) -> new Calc().add(req.params(":a"),req.params(":b")));
	    
	    get("/test", (req,res) -> {
	    	res.type("application/json"); //mime type
	    	return "{\"now\":\"" + new Date().toString() + "\",\"status\":\"ok\"}";
	    });
	    
	    
	    get("/github/:query", (req,res) -> {
	    	res.type("application/json"); //mime type
	    	return new GitHubUser().getInfo(req.params(":query"));
	    });
	    
	    get("/language/:traducao", (req, res) -> new controller_tradutor().returnDados(req.params(":traducao")));
	    
	}
}
