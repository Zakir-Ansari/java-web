<h3 style="text-align: center; font-size: 20px;">Add Student Form</h3>
<div align="center" style="border: 1px solid #555753; margin: 1% 30%;">
<form action="AddStudent" method="post" style="margin-top: 30px; margin-bottom: 30px;">
	<table>
		<tr>
			<td>Roll No:</td>
			<td><input type="number" name="roll" /></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" required /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" required /></td>
		</tr>
		<tr>
			<td>Sex:</td>
			<td><input type="radio" name="sex" value="male" /> Male <input
				type="radio" name="sex" value="female" /> Female</td>
		</tr>
		<tr>
			<td>Course:</td>
			<td><select name="course">
					<option>Java</option>
					<option>.Net</option>
					<option>PHP</option>
					<option>Android</option>
					<option>Hadoop</option>
					<option>Selenium</option>
			</select></td>
		</tr>
		<tr>
			<td>Fee:</td>
			<td><input type="number" name="fee" /></td>
		</tr>
		<tr>
			<td>Paid:</td>
			<td><input type="number" name="paid" /></td>
		</tr>
		<tr>
			<td>Due:</td>
			<td><input type="number" name="due" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><textarea name="address"
					style="width: 300px; height: 100px;"></textarea></td>
		</tr>
		<tr>
			<td>Contact No:</td>
			<td><input type="text" name="contact" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-default" value="Save Student" /></td>
		</tr>
	</table>
</form>
</div>
