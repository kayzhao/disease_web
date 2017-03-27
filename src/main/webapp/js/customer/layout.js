/**
 * cola style http://js.cytoscape.org/demos/2ebdc40f1c2540de6cf0/
 */
var colastyle = [ {
	"selector" : "core",
	"style" : {
		"selection-box-color" : "#AAD8FF",
		"selection-box-border-color" : "#8BB0D0",
		"selection-box-opacity" : "0.5"
	}
}, {
	"selector" : "node",
	"style" : {
		"width" : "mapData(score, 0, 0.006769776522008331, 20, 60)",
		"height" : "mapData(score, 0, 0.006769776522008331, 20, 60)",
		"content" : "data(name)",
		"font-size" : "12px",
		"text-valign" : "center",
		"text-halign" : "center",
		"background-color" : "#555",
		"text-outline-color" : "#555",
		"text-outline-width" : "2px",
		"color" : "#fff",
		"overlay-padding" : "6px",
		"z-index" : "10"
	}
}, {
	"selector" : "node[?attr]",
	"style" : {
		"shape" : "rectangle",
		"background-color" : "#aaa",
		"text-outline-color" : "#aaa",
		"width" : "16px",
		"height" : "16px",
		"font-size" : "6px",
		"z-index" : "1"
	}
}, {
	"selector" : "node[?query]",
	"style" : {
		"background-clip" : "none",
		"background-fit" : "contain"
	}
}, {
	"selector" : "node:selected",
	"style" : {
		"border-width" : "6px",
		"border-color" : "#AAD8FF",
		"border-opacity" : "0.5",
		"background-color" : "#77828C",
		"text-outline-color" : "#77828C"
	}
}, {
	"selector" : "edge",
	"style" : {
		"curve-style" : "haystack",
		"haystack-radius" : "0.5",
		"opacity" : "0.4",
		"line-color" : "#bbb",
		"width" : "mapData(weight, 0, 1, 1, 8)",
		"overlay-padding" : "3px"
	}
}, {
	"selector" : "node.unhighlighted",
	"style" : {
		"opacity" : "0.2"
	}
}, {
	"selector" : "edge.unhighlighted",
	"style" : {
		"opacity" : "0.05"
	}
}, {
	"selector" : ".highlighted",
	"style" : {
		"z-index" : "999999"
	}
}, {
	"selector" : "node.highlighted",
	"style" : {
		"border-width" : "6px",
		"border-color" : "#AAD8FF",
		"border-opacity" : "0.5",
		"background-color" : "#394855",
		"text-outline-color" : "#394855",
		"shadow-blur" : "12px",
		"shadow-color" : "#000",
		"shadow-opacity" : "0.8",
		"shadow-offset-x" : "0px",
		"shadow-offset-y" : "4px"
	}
}, {
	"selector" : "edge.filtered",
	"style" : {
		"opacity" : "0"
	}
}, {
	"selector" : "edge[group=\"coexp\"]",
	"style" : {
		"line-color" : "#d0b7d5"
	}
}, {
	"selector" : "edge[group=\"coloc\"]",
	"style" : {
		"line-color" : "#a0b3dc"
	}
}, {
	"selector" : "edge[group=\"gi\"]",
	"style" : {
		"line-color" : "#90e190"
	}
}, {
	"selector" : "edge[group=\"path\"]",
	"style" : {
		"line-color" : "#9bd8de"
	}
}, {
	"selector" : "edge[group=\"pi\"]",
	"style" : {
		"line-color" : "#eaa2a2"
	}
}, {
	"selector" : "edge[group=\"predict\"]",
	"style" : {
		"line-color" : "#f6c384"
	}
}, {
	"selector" : "edge[group=\"spd\"]",
	"style" : {
		"line-color" : "#dad4a2"
	}
}, {
	"selector" : "edge[group=\"spd_attr\"]",
	"style" : {
		"line-color" : "#D0D0D0"
	}
}, {
	"selector" : "edge[group=\"reg\"]",
	"style" : {
		"line-color" : "#D0D0D0"
	}
}, {
	"selector" : "edge[group=\"reg_attr\"]",
	"style" : {
		"line-color" : "#D0D0D0"
	}
}, {
	"selector" : "edge[group=\"user\"]",
	"style" : {
		"line-color" : "#f0ec86"
	}
} ];

/**
 * visual style ,from http://js.cytoscape.org/demos/b7c65115947d9e0e8ec8/
 */
var visualstyle = [ {
	selector : 'node',
	style : {
		'shape' : 'data(faveShape)',
		'width' : 'mapData(weight, 40, 80, 20, 60)',
		'content' : 'data(name)',
		'text-valign' : 'center',
		'text-outline-width' : 2,
		'color' : '#fff'
	}
}, {
	selector : 'node[faveColor]',
	style : {
		'text-outline-color' : 'data(faveColor)',
		'background-color' : 'data(faveColor)',
	}
}, {
	selector : 'edge',
	style : {
		'curve-style' : 'bezier',
		'opacity' : 0.666,
		'width' : 'mapData(strength, 70, 100, 2, 6)',
		'target-arrow-shape' : 'triangle',
		'source-arrow-shape' : 'circle',

	}
}, {
	selector : 'edge[faveColor]',
	style : {
		'line-color' : 'data(faveColor)',
		'source-arrow-color' : 'data(faveColor)',
		'target-arrow-color' : 'data(faveColor)'

	}
}, {
	selector : ':selected',
	style : {
		'border-width' : 3,
		'border-color' : '#333'
	}
}, {
	selector : 'edge.questionable',
	style : {
		'line-style' : 'dotted',
		'target-arrow-shape' : 'diamond'
	}
}, {
	selector : '.faded',
	style : {
		'opacity' : 0.25,
		'text-opacity' : 0
	}
} ];

/**
 * compound style http://js.cytoscape.org/demos/5b192c88616af2f75344/
 */

var compoundstyle = [ {
	selector : 'node',
	css : {
		'content' : 'data(id)',
		'text-valign' : 'center',
		'text-halign' : 'center'
	}
}, {
	selector : '$node > node',
	css : {
		'padding-top' : '10px',
		'padding-left' : '10px',
		'padding-bottom' : '10px',
		'padding-right' : '10px',
		'text-valign' : 'top',
		'text-halign' : 'center',
		'background-color' : '#bbb'
	}
}, {
	selector : 'edge',
	css : {
		'target-arrow-shape' : 'triangle',
		'curve-style' : 'bezier'
	}
}, {
	selector : ':selected',
	css : {
		'background-color' : 'black',
		'line-color' : 'black',
		'target-arrow-color' : 'black',
		'source-arrow-color' : 'black'
	}
} ];
/**
 * default style
 */
var cystyle = [ {
	selector : 'node',
	style : {
		'content' : 'data(id)',
		'text-valign' : 'top',
		'text-halign' : 'center',
		'shape' : 'circle',
		'height' : 20,
		'width' : 20,
		'background-color' : '#63B8FF',
		'color' : '#777'
	}
}, {
	selector : 'edge',
	style : {
		'label' : 'data(label)',
		'color' : 'red',
		'edge-text-rotation' : 'autorotate',
		'curve-style' : 'haystack',
		'haystack-radius' : 0,
		'width' : 1,
		'opacity' : 1,
		'line-color' : '#000'
	}
}, {
	selector : ':selected',
	style : {
		'background-color' : '#FFFF00',
		'line-color' : '#FF0000'
	}
} ];