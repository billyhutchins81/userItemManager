<%@page import="java.util.*,testpack.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<center>
</table>

<jsp:useBean id="user" class="testpack.User" scope="session"></jsp:useBean>
<h2>Create New Item Form</h2>
<form action='AddItem' method='post'>
	Item Name: <input type='text' name='itemName' required>&nbsp;
	Item Quantity: <input type='text' name='itemQty' required>&nbsp;
	<input type='submit' value='Create Item'> 
	<input type='hidden' name='userId' value=<jsp:getProperty property="uid" name="user"/>>
</form>

</td>
</tr>
</table>
</center>