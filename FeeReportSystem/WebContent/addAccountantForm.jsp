<form class="AccountantForm" action="AddAccountant" method="post" style="margin-top: 30px; margin-bottom: 30px;">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" required /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" required /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" required /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><textarea name="address" style="width:300px; height:100px;"></textarea></td>
        </tr>
        <tr>
            <td>Contact:</td>
            <td><input type="text" name="contact" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Add Accountant" /></td>
        </tr>
    </table>
</form>