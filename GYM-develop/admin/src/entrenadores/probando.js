class Formato extends Comando{
	cambiarFormato(dates){
		console.log("ME LLAMÓ");
		var opera1 = dates.split(' ');
	    switch(opera1[0]){
		    case "ene":
		    opera1[0]="jan"
		    break;
		    case "ago":
		    opera1[0]="aug"
		    break;
		    case "dic":
		    opera1[0]="dec"
		    break;
		    case "ene":
		    opera1[0]="jan"
		    break;
		    case "abr":
		    opera1[0]="apr"
		    break;
    	}
    	dates= opera1[0]+" "+ opera1[1]+" "+ opera1[2]
    	var date = new Date(dates);
    	return((date.toLocaleDateString()));
	}
	ejecutar(){
		
	}
}