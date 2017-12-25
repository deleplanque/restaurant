package deleplanque.dylan.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deleplanque.dylan.restaurant.entity.Tables;
import deleplanque.dylan.restaurant.services.ITableService;

@Controller
@RequestMapping("/api")
public class TableController {


	@Autowired
	ITableService tableService;
	
	@RequestMapping(value="/getTables", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tables>> getTables(){
		return new ResponseEntity<List<Tables>>(tableService.getTables(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getTables/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tables>> getTablesByIdSalle(@PathVariable("id") int id){
		return new ResponseEntity<List<Tables>>(tableService.getTablesByIdSalle(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getTable/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> getTablesById(@PathVariable("id") int id){
		return new ResponseEntity<Tables>(tableService.getTablesById(id), HttpStatus.OK);
	}
}
