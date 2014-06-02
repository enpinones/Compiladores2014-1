#!/bin/sh

#
# Script de ejemplo para compilar y ejecutar el compilador.
#

function prepare {
# preparaciones: compilar, generar archivos, etc.
# se recomienda usar alguna herramienta como ant o make.
:
# make
}

function scan {

}

function parse {

}

function stable {

}

function subtypes {

}

function incl {

}


while getopts CSAPTIo:i: o
do
    case "$o" in
	o) output="$OPTARG";;
	i) input="$OPTARG";;
	C) function total { prepare; };;
	A) function total { parse $@; };;
	S) function total { scan $@; };;
	P) function total { stable $@; };;
	T) function total { subtypes $@; };;
	I) function total { incl $@; };;
    esac
done

total $input $output

unset -f compile
unset -f scan
unset -f parse
unset -f stable
unset -f subtypes
unset -f incl
unset -f total
