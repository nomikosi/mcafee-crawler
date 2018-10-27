/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcafee.BittrexConnector;

/**
 *
 *  @author nomikosi
 */
public class ReconnectionAttemptsExceededException extends RuntimeException {
	
	  private static final long serialVersionUID = 3756544403778584892L;
	  public ReconnectionAttemptsExceededException(String message) { super(message); }

	}