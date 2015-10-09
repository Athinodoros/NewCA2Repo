/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#table thead").append("<tr><th>id</th><th>cvr</th><th>numOfEmployees</th><th>email</th><th>phones</th><th>action</th></tr>");
    $url = '/CA2/api/company';
    var full = function () {
        $.ajax({
            type: 'GET',
            url: $url + "/all",
            datatype: "json",
            success: function (data, textStatus, jqXHR) {
                console.log(data.length);

                for (var i = 0; i < data.length; i++) {
                    var cvr = "<td>" + data[i].cvr + "</td>";
                    var numOfEmployees = "<td>" + data[i].numOfEmployees + "</td>";
                    var id = "<td>" + data[i].id + "</td>";
                    var email = "<td>" + data[i].email + "</td>";
                    var phonelist;
                    for (var j = 0; i < data[i].phones; j++) {
                        phonelist = data[i].phones[j] + "<br/>";
                    }
                    var $edit = "<td><a href='/CA2/edit/edit.html' class='" + data[i].id + "' data-id='" + data[i].id + "' >edit</a>  ";
                    var $delete = " / <a href='#' class='" + data[i].id +  "' >delete</a> </td> ";
                    var phones = "<td>" + phonelist + "</td>";
                    console.log("<tr>" + id + cvr + numOfEmployees + email + phones + "</tr>");
                    $("#table").append("<tr>" + id + cvr + numOfEmployees + email + phones + $edit + $delete + "</tr>");
                }

                //$("#table").append("</tbody>");
                
            }

        });
    };
    full();

    $(document).on("click", "a", function () {
        //$.cookie.defineProperties( "actionss" , "company");
        
        var act ="company";
        var myA = this;
        if (this.innerText === "edit") {
//            document.cookie="id="+ 32434 ;
            location.reload();
        } else if (this.innerText === "delete") {
            alert('/CA2/api/company/' + $(myA).attr("class"));

            $.ajax({
                type: 'DELETE',
                
                url: '/CA2/api/company/' + $(myA).attr("class"),
                success: function (data, textStatus, jqXHR) {
                    location.reload();
                    full();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("errrrrrooor");
                }
            });

        }
    });

});