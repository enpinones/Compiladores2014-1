#!/bin/sh

#
# Script para compilar y ejecutar el compilador.
#
# Se puede modificar libremente mientras no cambie
# el nombre, ni la forma de utilizarlo.
# 


function compile {
#
# COMPLETAR.
# 

# make

}

function scan {


IN=$1
OUT=$2

#
# COMPLETAR.
#

# java Main $IN > $OUT

}


while getopts CSo:i: o
do
    case "$o" in
	C) compile=1;;
	o) output="$OPTARG";;
	i) input="$OPTARG";;
	S) scan=1;;
    esac
done

if [ ! -z "$compile" ]; then
    compile;
fi

if [ ! -z "$scan" ]; then
    scan $input $output
fi

unset -f scan
unset -f compile
    
