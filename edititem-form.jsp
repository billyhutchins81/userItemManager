<%@page import="testpack.OurUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<center>

	<h2>Edit Item Form</h2>
    <form action='EditItem' method='post'>
	Item Name: <input type='text' name='itemName' required>&nbsp;
	Item Quantity: <input type='text' name='itemQty' required>&nbsp;
	<input type='submit' value='Update Item'>
	<input type='hidden' name='userId' value='" + u.getUid() + "'>
	</form>

	</td></tr></table>
</center>