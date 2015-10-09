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
                    var street = "<td>"+data[i].streetName+"</td>";
                    var city = "<td>"+data[i].city+"</td>";
                    var phonelist;
                    for (var j = 0; i <data[i].phones.lenght; j++) {
                        phonelist = data[i].phones[j].phoneNumber+ "<br/>";
                        //console.log(data[i].phones);
                    }
                    var $edit = "<td><a href='/CA2/edit/edit.html' class='" + data[i].id + "' data-id='" + data[i].id + "' >edit</a>  ";
                    var $delete = " / <a href='#' class='" + data[i].id + "' >delete</a> </td> ";
                     console.log(data[i].phones);
                    var hobies;
                    for (var j = 0; i <data[i].hobby; j++) {
                        hobies = data[i].hobby[j]+ "<br/>";
                    }
                    var phones = "<td>"+phonelist+"</td>";
                    //console.log("<tr>"+id+firstName+lastName+email+phones+"</tr>");
                    $("#table").append("<tr>"+id+firstName+lastName+phones+email+street+city+$edit + $delete+"</tr>");
                }
            }
        
    });
    };
    load();
//    // checks if there is input in fields
//    $("#myForm").validate({
//                rules: {
//                    fname: {
//                        required: true
//                    },
//                    lname:{
//                        required: true,
//                    },
//                    phone: {
//                        required: true
//                    },
//                    email: {
//                        required: true,
//                    },
//                },
//                submitHandler: function(form) {
//                     form.submit();
//                 }
//      });
      
    $("#submit").click(function() {
        var $type = "POST";
        var data = {firstName: $("#fname").val(), lastName: $("#lname").val(), 
             //phones:{phoneNumber:$("#phone").val()},
             email: $("#email").val(), streetName: $("#street").val(), city: $("#city").val() };
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
    
        $(document).on("click", "a", function () {

        var act = "company";
        var myA = this;
        if (this.innerText === "edit") {
            localStorage.setItem("id",$(myA).attr('class') );
            var val = localStorage.getItem("xxx");
            console.log("sadsgadfijcakvlmsdvamwdv     " + val);
            document.localStorage.
                    $(window).load($(myA).attr("href"));
        } else if (this.innerText === "delete") {

            $.ajax({
                type: 'DELETE',
                url: '/CA2/api/person/' + $(myA).attr("class"),
                success: function (data, textStatus, jqXHR) {
                    location.reload();
                    load();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("errrrrrooor");
                }
            });

        }
    });
});


