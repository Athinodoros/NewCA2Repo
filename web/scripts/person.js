/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    var $url ='/CA2/api/person';
    
    function load(){
    $.ajax({
            type: 'GET',
            url: $url + "/all",
            datatype: "json",
            success: function (data) {
                 console.log(data);
                for (var i = 0; i < data.length; i++) {
                    var id = "<td>"+data[i].id+"</td>";
                    var firstName = "<td>"+data[i].firstName+"</td>";
                    var lastName = "<td>"+data[i].lastName+"</td>";
                    var email = "<td>"+data[i].email+"</td>";
                    var phonelist;
                    for (var j = 0; i <data[i].phones.lenght; j++) {
                        phonelist = data[i].phones[j].phoneNumber+ "<br/>";
                        //console.log(data[i].phones);
                    }
                     console.log(data[i].phones);
                    var hobies;
                    for (var j = 0; i <data[i].hobby; j++) {
                        hobies = data[i].hobby[j]+ "<br/>";
                    }
                    var phones = "<td>"+phonelist+"</td>";
                    //console.log("<tr>"+id+firstName+lastName+email+phones+"</tr>");
                    $("#table").append("<tr>"+id+firstName+lastName+phones+email+"</tr>");
                }
            }
        
    });
    };
    load();
    
    $("#submit").click(function() {
        var $type = "POST";
        var data = {firstName: $("#fname").val(), lastName: $("#lname").val(), 
             //phones:{phoneNumber:$("#phone").val()},
             email: $("#email").val()};
        var $url = "/CA2/api/person";
        $.ajax({
            type: $type,
            url: $url,
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                location.reload();
                load();
            }
        });
    });
});


