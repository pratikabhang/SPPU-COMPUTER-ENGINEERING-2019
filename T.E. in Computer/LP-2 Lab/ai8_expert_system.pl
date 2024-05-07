symptom(fever, [flu, malaria, common_cold]).
symptom(cough, [common_cold, bronchitis, pneumonia]).
symptom(headache, [migraine, tension_headache, sinusitis]).
symptom(fatigue, [anemia, depression, hypothyroidism]).
symptom(rash, [allergy, eczema, measles]).

possible_cause(Symptom, Cause) :-
    symptom(Symptom, Causes),
    member(Cause, Causes).

causes_for_symptoms(Symptoms, PossibleCauses) :-
    findall(Cause, (member(Symptom, Symptoms), possible_cause(Symptom, Cause)), PossibleCauses).

ask_for_response(Response) :-
    write('Do you want to ask for more symptoms? (yes/no): '),
    read(Response),
    skip_line. 
skip_line :-
    repeat,
    get_char(Char),
    (Char == '\n' -> ! ; skip_line).

main :-
    repeat,
    write('Enter symptoms (comma-separated, or enter "." to exit): '),
    read_line_to_codes(user_input, Input),
    (Input == [46] -> ! ; % Check for end-of-file character (ASCII code for '.')
     atom_codes(Atom, Input),
     atomic_list_concat(Symptoms, ',', Atom),
     causes_for_symptoms(Symptoms, PossibleCauses),
     write('Possible causes for '), write(Symptoms), write(' are: '), writeln(PossibleCauses),
     ask_for_response(Response),
     Response \= yes),
    !.

:- initialization(main).
