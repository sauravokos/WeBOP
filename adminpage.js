    var y


    function addFlightRow(){
        var f = document.getElementById("addFlight")
        var a = f.flightName.value
        var b = f.seatingCapacity.value
        var c = f.reservationCapacity.value

        if(a.length==0 || b.length==0 || c.length==0){
            alert("Input Fields can't be empty!")
            return false
        }

        if(parseInt(b)<parseInt(c)){
            alert("Reservation Capacity cannot be lesser than Seating Capacity!")
            return false
        }
        else{
            $('#addModal').modal('hide');
        
        $("table tbody").append(
            '<tr onclick="getRow(this)">'+
                            '<td>'+a+'</td>'+
                            '<td>'+b+'</td>'+
                            '<td>'+c+'</td>'+
                            '<td>'+
                                '<a href="#editModal" class="edit" onclick="defaultFlight(this.parentNode.parentNode)"  data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>'+
                                '<a href="#deleteModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>'+
                            '</td>'+
                        '</tr>'
        )

        f.flightName.value = ""
        f.seatingCapacity.value = ""
        f.reservationCapacity.value = ""
        }
       return true
    }

    function getRow(x){
        y = x.rowIndex
        console.log(y)
    }

    function editFlightRow(){
        var f = document.getElementById("editFlight")
        var a = f.flightName.value
        var b = f.seatingCapacity.value
        var c = f.reservationCapacity.value

        if(a.length==0 || b.length==0 || c.length==0){
            alert("Input Fields can't be empty!")
            return false
        }
        if(parseInt(b)<parseInt(c)){
            alert("Reservation Capacity cannot be lesser than Seating Capacity!")
            return false
        }
        else{
            $('#editModal').modal('hide');
        var table = document.getElementById("flightTable")

        table.rows[y].cells[0].innerHTML = a;
        table.rows[y].cells[1].innerHTML = b;
        table.rows[y].cells[2].innerHTML = c;

        f.flightName.value = ""
        f.seatingCapacity.value = ""
        f.reservationCapacity.value = ""
        }
    }

    function deleteFlight(){
        var f = document.getElementById("flightTable")
        var a = f.deleteRow(y)
    }

    function deleteRoute(){
        var f = document.getElementById("routeTable")
        var a = f.deleteRow(y)
    }

    function addRouteRow(){

        var f = document.getElementById("addRoute")
        var a = f.flightName.value
        var b = f.source.value
        var c = f.destination.value
        var d = f.distance.value
        var e = f.duration.value
        var g = f.cost.value

       
        
        $("table tbody").append(
            '<tr onclick="getRow(this)">'+
                            '<td>'+a+'</td>'+
                            '<td>'+b+'</td>'+
                            '<td>'+c+'</td>'+
                            '<td>'+d+'</td>'+
                            '<td>'+e+'</td>'+
                            '<td>'+g+'</td>'+
                            '<td>'+
                                '<a href="#editModal" class="edit" onclick="defaultRoute(this.parentNode.parentNode)" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>'+
                                '<a href="#deleteModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>'+
                            '</td>'+
                        '</tr>'
        )

        f.flightName.value = ""
        f.source.value = ""
        f.destination.value = ""
        f.distance.value = ""
        f.duration.value = ""
        f.cost.value = ""
    }

    function editRouteRow(){
        var f = document.getElementById("editRoute")
        var a = f.flightName.value
        var b = f.source.value
        var c = f.destination.value
        var d = f.distance.value
        var e = f.duration.value
        var g = f.cost.value

        var table = document.getElementById("routeTable")

        table.rows[y].cells[0].innerHTML = a;
        table.rows[y].cells[1].innerHTML = b;
        table.rows[y].cells[2].innerHTML = c;
        table.rows[y].cells[3].innerHTML = d;
        table.rows[y].cells[4].innerHTML = e;
        table.rows[y].cells[5].innerHTML = g;

        f.flightName.value = ""
        f.source.value = ""
        f.destination.value = ""
        f.distance.value = ""
        f.duration.value = ""
        f.cost.value = ""
    }

    function search(){
        var se = document.getElementById("myInput").value
        var table = document.getElementById("passengerTable");
        for (var i = 1; i < table.rows.length; i++) {
            var firstCol = table.rows[i].cells[0].innerHTML; //first column
            if(firstCol.substring(0,se.length).toLowerCase() == se.toLowerCase()){
                console.log(firstCol)
            }
         }

    }

    function defaultFlight(x){

        x = x.rowIndex
        var table = document.getElementById("flightTable")
        f = document.getElementById("editFlight")

        f.flightName.value = table.rows[x].cells[0].innerHTML
        f.seatingCapacity.value = table.rows[x].cells[1].innerHTML
        f.reservationCapacity.value = table.rows[x].cells[2].innerHTML
    }

    function defaultRoute(x){

        x = x.rowIndex
        var table = document.getElementById("routeTable")
        f = document.getElementById("editRoute")

        f.flightName.value = table.rows[x].cells[0].innerHTML
        f.source.value = table.rows[x].cells[1].innerHTML
        f.destination.value = table.rows[x].cells[2].innerHTML
        f.distance.value = table.rows[x].cells[3].innerHTML
        f.duration.value = table.rows[x].cells[4].innerHTML
        f.cost.value = table.rows[x].cells[5].innerHTML


    }
