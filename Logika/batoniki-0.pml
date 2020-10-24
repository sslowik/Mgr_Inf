mtype = {PLN2, PLN5, MILK, DARK}
int m = 10;
int d = 5;
int cash = 45;
int machine_money = 0;
chan money=[1] of {mtype};
chan choco=[1] of {mtype};
mtype x;
active proctype user(){
	mtype bar;
	do
	:: if ::(cash>=2 && m>0) ->atomic { 
		money!PLN2;printf("wrzucam 2 zl\n");
		cash = cash - 2;
		choco?bar;printf("zjadam jasny\n");
		m--;
		} 
	      ::(cash>=5 && d>0) -> atomic {
			money!PLN5;printf("wrzucam 5 zl\n"); 
			cash = cash - 5;
			choco?bar;printf("zjadam ciemny\n");
			d--;
		} 
	   fi
	od
}
active proctype machine(){
	mtype sum;
	do
	:: money?sum;
		if ::(sum==PLN2)->atomic{ choco!MILK; printf("MILK"); machine_money += 2; assert(machine _money+cash==45); }
		   ::(sum==PLN5)->atomic{ choco!DARK; printf("DARK"); machine_money+= 5; assert(machine _money+cash==45);}
		fi
	od
}

ltl propA { [](x==MILK) }
