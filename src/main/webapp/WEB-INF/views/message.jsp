
<p>
	<% 
		String result = (String)request.getAttribute("result");
		if(result!=null){
			out.print(result);
		}
	%>
</p>