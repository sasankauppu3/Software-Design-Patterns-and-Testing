package ast4;
/**
 * NodeType is an enum which has different type of child classes which implemented Node
 */
public enum NodeType {
	NODEVARIABLE,
	NODESTRING,
	NODENUMBER,
	NODEINFIX,
	NODEPREFIX,
	NODESEQUENCE,
	NODEASSIGNMENT,
	NODEDECLARATION
}
