/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    $url ='/CA2/api/company';
    $.ajax({
            type : 'GET',
            url : $url +"/all",
            datatype : "json",
            success: function (data, textStatus, jqXHR) {
            console.log(data.length);
          
                for (var i = 0; i < data.length; i++) {
                    var cvr = "<td>"+data[i].cvr+"</td>";
                    var numOfEmployees = "<td>"+data[i].numOfEmployees+"</td>";
                    var id = "<td>"+data[i].id+"</td>";
                    var email = "<td>"+data[i].email+"</td>";
                    var phonelist;
                    for (var j = 0; i <data[i].phones; j++) {
                        phonelist = data[i].phones[j]+ "<br/>"
                    }
                    var phones = "<td>"+phonelist+"</td>";
                    console.log("<tr>"+id+cvr+numOfEmployees+email+phones+"</tr>");
                    $("#table").append("<tr>"+id+cvr+numOfEmployees+email+phones+"</tr>");
                }
               
                
           
        }
            
    });
    
    
    
    
});