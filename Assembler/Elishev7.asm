; First program
;two numbers are entered and added and printed
;THIS WORKS!!!!!!!!!!!!!!!
	.MODEL SMALL
	.386
	.STACK	100h
	.DATA
nbr1	DD	25 Dup (0)
ans		DD	4268
good	DB	'great job', 10,13,'$'
bad1	DB	'woops', 10,13,'$'
req1	DB	'Enter number:','$'
testNum	DB	'correct', '$'
nine	DD	9
ten		DD	10
hello	DD	56
printMessage DB	'The sum is'
printAns DB 10 dup ('_'), '$'
A		DD	0
D 		DD	0
;N		DD	4568

;sumChar	DB	'x',10,13,'$'

	.CODE
GETDNUM Macro
		sub ebx, ebx
		mov nbr1 +[ecx], ebx
		
	; get a character from the user
 gtDigit: mov ah, 1h
		int	21h
		cmp	al, 13 	;compare input to carriagereturn
		je	gotNumb		;jump if all equal 
		sub	al,30h
		;get rid of garbage in register
		mov	bl, al
		;sub bl, 30h
		sub eax, eax
		mov eax, nbr1+[ecx]
		
		imul ten
		add	eax, ebx
		mov nbr1 + [ecx], eax
		
		jmp	gtDigit 	;loops back to gtDigit
ENDM
PUTDNUM	Macro	
	;print them	
		sub ecx, ecx
		mov ecx, nine
	NextDigit:	cdq
		idiv ten
		add dl, 30h
		mov printAns+[ecx], dl
		cmp eax, 0
		je 	allDone
		dec	ecx
		jmp nextDigit
	;print the numbers
allDone:mov	dx, OFFSET printMessage
	mov	ah, 9h
	int	21h
	jmp terminate
ENDM
	
Addit	PROC
		mov	ax, @data 	;sets up area
		mov ds, ax
; put out initial message
		mov	dx, OFFSET req1
		mov	ah, 9h
		int	21h
		
		sub ecx, ecx
newNumb: GETDNUM
		cmp	al, 13 	;compare input to carriagereturn
		je	gotNumb		;jump if all equal 
		sub	al,30h	;loops back to gtDigit
gotNumb:
		add ecx,4
		cmp ecx, 4
		jle newNumb

rllydone:
	;add the numbers
	mov eax, nbr1
	add eax, nbr1+4
	
PUTDNUM
	
; terminate the program		
terminate:	mov al, 0
	mov	ah, 4ch
	int	21h
Addit	ENDP
	END	Addit
